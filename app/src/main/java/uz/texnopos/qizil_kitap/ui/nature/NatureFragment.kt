package uz.texnopos.qizil_kitap.ui.nature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_nature.*
import uz.texnopos.qizil_kitap.R
import uz.texnopos.qizil_kitap.data.RedBookDatabase
import uz.texnopos.qizil_kitap.data.dao.NatureDao

class NatureFragment : Fragment(R.layout.fragment_nature) {
    private val myAdapter = NatureListAdapter()
    private lateinit var dao : NatureDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = myAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        dao = RedBookDatabase.getInstance(requireContext()).dao()
        setData()
    }

    private fun setData(){
    myAdapter.models = dao.getAllNature()
    }
}