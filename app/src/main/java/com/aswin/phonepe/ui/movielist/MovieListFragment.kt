package com.aswin.phonepe.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aswin.phonepe.R
import com.aswin.phonepe.databinding.MovieListFragmentBinding
import com.aswin.phonepe.models.movie.MovieData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val mViewModel: MovieListViewModel by viewModels()
    private lateinit var mBinding: MovieListFragmentBinding
    private lateinit var mMovieListAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = MovieListFragmentBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBindings()
        initUI()
        attachObservers()
    }

    private fun attachObservers() {
        mViewModel.showErrorLD.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                mViewModel.resetError()
            }
        }

        mViewModel.movieListLD.observe(viewLifecycleOwner) {
            it?.let {
                mMovieListAdapter.setData(it)
            }
        }
    }

    private fun initUI() {

        mBinding.filterFab.setOnClickListener {
            findNavController().navigate(R.id.action_movieListFragment_to_favouriteListBottomSheetFragment)
        }

        mMovieListAdapter = MovieListAdapter(object : MovieListAdapterInterface {
            override fun addToFavourite(movieData: MovieData) {
                findNavController().navigate(
                    MovieListFragmentDirections.actionMovieListFragmentToFavouriteListBottomSheetFragment(
                        movieData
                    )
                )
            }
        })
        mBinding.movieListRv.adapter = mMovieListAdapter
    }

    private fun initBindings() {
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel
    }
}