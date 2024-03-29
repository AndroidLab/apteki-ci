package ru.apteka.symptoms_diseases.presentation

import android.util.Log
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.apteka.components.ui.BaseFragment
import ru.apteka.components.ui.delegate_adapter.CompositeDelegateAdapter
import ru.apteka.symptoms_diseases.R
import ru.apteka.symptoms_diseases.data.model.SymptomModel
import ru.apteka.symptoms_diseases.databinding.SymptomsDiseasesFragmentBinding


/**
 * Представляет фрагмент "Симптомы и болезни".
 */
@AndroidEntryPoint
class SymptomsDiseasesFragment : BaseFragment<SymptomsDiseasesViewModel, SymptomsDiseasesFragmentBinding>() {

    override val viewModel: SymptomsDiseasesViewModel by viewModels()
    override val layoutId: Int = R.layout.symptoms_diseases_fragment

    private val lettersAdapter by lazy {
        CompositeDelegateAdapter(
            SymptomsAdapter(::onSymptomClick),
            SymptomsTitleAdapter()
        )
    }

    override fun onViewBindingInflated(binding: SymptomsDiseasesFragmentBinding) {
		binding.viewModel = viewModel

        binding.rvSymptoms.adapter = lettersAdapter

        viewModel.letters.observe(viewLifecycleOwner) {
            lettersAdapter.swapData(it)
        }

        binding.etSymptoms.doAfterTextChanged {
            viewModel.onTextChange.invoke(it.toString())
        }
    }

    private fun onSymptomClick(symptom: SymptomModel) {
        Log.d("myL", "symptom " + symptom)
    }


    override fun onResume() {
        super.onResume()
        binding.symptomsDiseasesToolbar.apply {
            tvToolbarTitle.text = getString(R.string.symptoms_diseases_title)
        }
    }
}