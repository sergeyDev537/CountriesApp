package com.most4dev.countriesapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.most4dev.countriesapp.databinding.FragmentCountriesListBinding
import com.most4dev.countriesapp.domain.entity.CountriesShort
import com.most4dev.countriesapp.presentation.adapters.CountriesListAdapter
import com.most4dev.countriesapp.presentation.utils.showSnackBar
import com.most4dev.countriesapp.presentation.viewModels.CountriesListViewModel

class CountriesListFragment : Fragment() {

    private lateinit var countriesListAdapter: CountriesListAdapter

    private var _binding: FragmentCountriesListBinding? = null
    private val binding: FragmentCountriesListBinding
        get() = _binding ?: throw RuntimeException("FragmentCountriesListBinding is null")

    private val countriesViewModel by lazy {
        ViewModelProvider(this)[CountriesListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountriesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        setObserve()
        setClick()
        loadList()
    }

    private fun loadList() {
        visibleProgressBar(true)
        countriesViewModel.getListCountries()
    }

    private fun setClick() {
        binding.fabRefresh.setOnClickListener {
            loadList()
        }
    }

    private fun visibleProgressBar(boolean: Boolean){
        if (boolean){
            with(binding){
                progress.visibility = View.VISIBLE
                rvCountries.visibility = View.GONE
            }
        }
        else{
            with(binding){
                progress.visibility = View.GONE
                rvCountries.visibility = View.VISIBLE
            }
        }
    }

    private fun setUpAdapter() {
        countriesListAdapter = CountriesListAdapter()
        binding.rvCountries.adapter = countriesListAdapter
        countriesListAdapter.onCountryItemClickListener = {
            launchCountryItemFragment(it)
        }
    }

    private fun launchCountryItemFragment(countriesShort: CountriesShort) {
        findNavController().navigate(
            CountriesListFragmentDirections.actionCountriesListFragmentToCountryItemFragment(
                countriesShort.name
            )
        )
    }

    private fun setObserve() {
        countriesViewModel.listCountry.observe(viewLifecycleOwner) {
            countriesListAdapter.submitList(it)
            countriesViewModel.clearErrorLoadList()
            visibleProgressBar(false)
        }
        countriesViewModel.errorLoadData.observe(viewLifecycleOwner){
            binding.root.showSnackBar(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}