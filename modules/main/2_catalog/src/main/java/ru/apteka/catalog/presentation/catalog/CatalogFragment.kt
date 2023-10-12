package ru.apteka.catalog.presentation.catalog

import android.util.Log
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.apteka.common.ui.BaseFragment
import ru.apteka.catalog.R
import ru.apteka.catalog.databinding.CatalogFragmentBinding


/**
 * Представляет фрагмент "Каталог".
 */
@AndroidEntryPoint
class CatalogFragment : BaseFragment<Nothing, CatalogFragmentBinding>() {

    override val layoutId: Int = R.layout.catalog_fragment

    override fun onViewBindingInflated(binding: CatalogFragmentBinding) {
        /*val controller = findNavController()
        binding.btnGoToScreen21.setOnClickListener {
            controller.navigate(
                CatalogFragmentDirections.toScreen21()
            )
        }*/
    }
}