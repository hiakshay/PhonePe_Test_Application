package com.akshay.phonepetestapplication.views.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.phonepetestapplication.databinding.HomeFragmentBinding
import com.akshay.phonepetestapplication.entities.MovieResult
import com.akshay.phonepetestapplication.viewmodels.HomeViewModel
import com.akshay.phonepetestapplication.views.ui.adapters.MovieListRecyclerViewAdapter

class HomeFragment : Fragment() {

    private val viewModel by activityViewModels<HomeViewModel>()

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.movieList.observe(viewLifecycleOwner) {
            showMovies(it.results)
        }
    }

    private fun showMovies(movieList: List<MovieResult>) {
        binding.movieListRecyclerView.visibility = View.VISIBLE
        binding.movieListRecyclerView.layoutManager = LinearLayoutManager(requireContext())


        binding.movieListRecyclerView.adapter =
            MovieListRecyclerViewAdapter(requireContext(), movieList)
    }

}