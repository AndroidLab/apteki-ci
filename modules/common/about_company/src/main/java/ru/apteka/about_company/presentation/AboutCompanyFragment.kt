package ru.apteka.about_company.presentation

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.apteka.about_company.R
import ru.apteka.about_company.databinding.AboutCompanyFragmentBinding
import ru.apteka.common.ui.BaseFragment


/**
 * Представляет фрагмент "О компании".
 */
@AndroidEntryPoint
class AboutCompanyFragment : BaseFragment<AboutCompanyViewModel, AboutCompanyFragmentBinding>() {

    override val viewModel: AboutCompanyViewModel by viewModels()
    override val layoutId: Int = R.layout.about_company_fragment

    override fun onViewBindingInflated(binding: AboutCompanyFragmentBinding) {

    }

    override fun onResume() {
        super.onResume()
        viewModel.navigationManager.hideToolbar()
    }

    override fun onStop() {
        super.onStop()
        viewModel.navigationManager.showToolbar()
    }
}