package com.aswin.phonepe.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.aswin.phonepe.databinding.FavouriteListFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteListBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var mBinding: FavouriteListFragmentBinding
    private val mViewModel: FavouriteListViewModel by viewModels()
    private val mNavArs: FavouriteListBottomSheetFragmentArgs by navArgs()

    private lateinit var mAdapter: FavouriteListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FavouriteListFragmentBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBindings()
        initUI()
    }

    private fun initUI() {
        mAdapter = FavouriteListAdapter(object : FavouriteListAdapterInterface {})
        mBinding.favouritesRv.adapter = mAdapter

        if (mNavArs.movie != null) {
            mBinding.addPlaylistTv.visibility = View.GONE
        } else {
            mBinding.addPlaylistTv.visibility = View.VISIBLE
        }
    }

    private fun initBindings() {
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.viewModel = mViewModel
    }
}