package dev.leonardom.androidintroduccion.presentation.product_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.leonardom.androidintroduccion.data.Product
import dev.leonardom.androidintroduccion.databinding.LayoutProductItemBinding

class ProductListAdapter : ListAdapter<Product, ProductListAdapter.ProductViewHolder>(
    ProductDiffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    class ProductViewHolder(
        itemBinding: LayoutProductItemBinding
    ): RecyclerView.ViewHolder(itemBinding.root) {

        private val image = itemBinding.imageViewProduct
        private val name = itemBinding.textViewProductName
        private val price = itemBinding.textViewProductPrice

        fun bind(product: Product) {

            name.text = product.name
            price.text = "$${product.price} MXN"

            image.load(product.imageURL)

        }
    }
}

object ProductDiffUtil: DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}













