package uz.texnopos.qizil_kitap.ui.nature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_nature.view.*
import uz.texnopos.qizil_kitap.R
import uz.texnopos.qizil_kitap.data.model.nature


class NatureListAdapter : RecyclerView.Adapter<NatureListAdapter.NatureViewHolder>() {

    inner class NatureViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun populateModels(nature : nature){
    itemView.textView1.text = nature.nameUzb
    itemView.textView2.text = nature.nameRus
    itemView.textView3.text = nature.nameEng
    }
    }
    var models : List<nature> = listOf()
    set(value) {
    field = value
    notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NatureViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nature,parent,false)
    return NatureViewHolder(view)
    }

    override fun onBindViewHolder(holder: NatureViewHolder, position: Int) {
    holder.populateModels(models[position])
    }

    override fun getItemCount(): Int {
    return models.size
    }
}