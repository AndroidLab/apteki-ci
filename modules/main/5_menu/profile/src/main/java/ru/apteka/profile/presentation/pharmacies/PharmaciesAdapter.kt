package ru.apteka.profile.presentation.pharmacies


import ru.apteka.components.ui.delegate_adapter.ViewBindingDelegateAdapter
import ru.apteka.profile.data.models.AptekaCardModel
import ru.apteka.profile.databinding.AptekaHolderBinding


/**
 * Представляет адаптер для спика аптек.
 */
class PharmaciesAdapter(private val onItemClick: (AptekaCardModel) -> Unit) :
    ViewBindingDelegateAdapter<AptekaCardModel, AptekaHolderBinding>(AptekaHolderBinding::inflate) {

    override fun AptekaHolderBinding.onBind(
        item: AptekaCardModel, position: Int,
        isFirst: Boolean,
        isLast: Boolean
    ) {
        model = item
        executePendingBindings()
        aptekaItem.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun isForViewType(item: Any) = item is AptekaCardModel

    override fun AptekaCardModel.getItemId() = apteka.uuid
}