package com.xgt.entrega_app_fragments_contra_api

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.xgt.entrega_app_fragments_contra_api.databinding.FragmentUserListBinding
import com.xgt.entrega_app_fragments_contra_api.model.UserResponse
import com.xgt.entrega_app_fragments_contra_api.network.RandomUserService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


//url base api: https://randomuser.me/api/
class UserListFragment : Fragment() {
    private var _binding: FragmentUserListBinding? = null
    private val binding
        get() = _binding!!
    private val adapter = UserAdapter {

        var myDate: String = it.dob.date.substring(0, 10)
        var myAgeShow: Int = it.dob.age
        var myAge: String = myAgeShow.toString()

        val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(
            it.name.first,
            it.name.last,
            myDate,
            myAge,
            it.location.country,
            it.picture.large
        )
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUser.layoutManager = GridLayoutManager(context, 2)
        binding.rvUser.adapter = adapter

        requestData()
    }

    private fun requestData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: RandomUserService = retrofit.create(RandomUserService::class.java)

        service.getUsers().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    adapter.submitList(response.body()?.users)
                } else {
                    Toast.makeText(context, "400", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(context, "Algo no ha funcionado como esperábamos", Toast.LENGTH_SHORT).show()
                Log.e("Retrofit", "Error: ${t.localizedMessage}", t)
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}