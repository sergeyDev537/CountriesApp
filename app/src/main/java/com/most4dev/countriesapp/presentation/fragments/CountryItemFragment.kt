package com.most4dev.countriesapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.most4dev.countriesapp.databinding.FragmentCountryItemBinding
import com.most4dev.countriesapp.presentation.utils.showSnackBar
import com.most4dev.countriesapp.presentation.viewModels.CountriesListViewModel

class CountryItemFragment : Fragment() {

    private val args by navArgs<CountryItemFragmentArgs>()
    private var _binding: FragmentCountryItemBinding? = null
    private val binding: FragmentCountryItemBinding
        get() = _binding ?: throw RuntimeException("FragmentCountryItemBinding is null")

    private val countriesViewModel: CountriesListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visibleLoadProgress(true)
        countriesViewModel.getItemCountry(args.countryName)
        setObserver()
    }

    private fun setObserver() {
        countriesViewModel.itemCountry.observe(viewLifecycleOwner) {
            binding.country = it
            visibleLoadProgress(false)
        }
        countriesViewModel.errorLoadItem.observe(viewLifecycleOwner){
            binding.root.showSnackBar(it)
        }
    }

    private fun visibleLoadProgress(boolean: Boolean){
        if (boolean){
            with(binding){
                progressLoadItem.visibility = View.VISIBLE
                constraintField.visibility = View.GONE
            }
        }
        else{
            with(binding){
                progressLoadItem.visibility = View.GONE
                constraintField.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}