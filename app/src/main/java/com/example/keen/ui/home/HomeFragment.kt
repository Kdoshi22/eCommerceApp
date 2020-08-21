package com.example.keen.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.keen.Adapter.MyPopularCategoriesAdapter
import com.example.keen.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private var recyclerView:RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        initView(root)

        // Bind Data
        homeViewModel.popularList.observe(viewLifecycleOwner , Observer {
            val listData = it
            val adapter = MyPopularCategoriesAdapter(requireContext(),listData)
            recyclerView!!.adapter = adapter
        })

        return root
    }

    private fun initView(root:View){
        recyclerView = root.findViewById(R.id.recycler_popular) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(context , RecyclerView.HORIZONTAL, false)
    }
}