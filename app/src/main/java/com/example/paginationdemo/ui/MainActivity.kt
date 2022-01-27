package com.example.paginationdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationdemo.R
import com.example.paginationdemo.builderobjects.RetroBuilder
import com.example.paginationdemo.databinding.ActivityMainBinding
import com.example.paginationdemo.model.Dhaba
import com.example.paginationdemo.model.DhabaLocationResponse
import com.example.paginationdemo.repo.Repostries
import com.example.paginationdemo.retroapi.ApiService
import com.example.paginationdemo.ui.adapter.ShowDhabaAdapter
import com.example.paginationdemo.viewmodel.GetAllDhabas
import com.example.paginationdemo.viewmodel.GetAllDhabasFactory
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<DhabaLocationResponse>
    lateinit var  layoutManager:LinearLayoutManager
    lateinit var recyclerAdapter:ShowDhabaAdapter
    lateinit var retro:ApiService
    lateinit var repo:Repostries
    lateinit var viewmodel: GetAllDhabas

    var pageno=1
    var iscrolled=false
    val limit=10



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.progressbar.visibility=View.VISIBLE

        list = arrayListOf()


        layoutManager=LinearLayoutManager(this)
        binding.showDhabaRecyclerview.layoutManager=layoutManager

        retro = RetroBuilder.AllDhaba().create(ApiService::class.java)
        repo = Repostries(retro, this)
         viewmodel = ViewModelProvider(
            this,
            GetAllDhabasFactory(repo)
        ).get(GetAllDhabas::class.java)




        recyclerAdapter = ShowDhabaAdapter(this, list)
        layoutManager = LinearLayoutManager(this)
        binding.showDhabaRecyclerview.layoutManager=layoutManager
        binding.showDhabaRecyclerview.adapter = recyclerAdapter

        binding.showDhabaRecyclerview.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                layoutManager.orientation
            )
        )

        viewmodel.getDhaba(this,"27.2046","77.4977","50000","10",pageno.toString())





        viewmodel.data3.observe(this, Observer {

            it?.data?.let {

               // val recyclerAdapter = ShowDhabaAdapter(this, it)
                if(it!=null){

                    list.addAll(it)
                    recyclerAdapter.notifyDataSetChanged()
                    binding.progressbar2.visibility=View.GONE
            }
                else{
                    Toast.makeText(this,"there is no list available",Toast.LENGTH_SHORT).show()

                }
            }
        })
        Handler().postDelayed(Runnable {

            binding.progressbar.visibility=View.GONE

        },3000)




       binding.showDhabaRecyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    iscrolled=true



            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                //for visible items on screen
                val vitem=layoutManager.childCount
                //for scrooled out items
                val skipped=layoutManager.findFirstVisibleItemPosition()
                //for total items
                val totalitem=binding.showDhabaRecyclerview.layoutManager?.itemCount


                //if visible item count and skipped item count is equals to total item count then we fetch new data
                if (iscrolled && vitem+skipped==totalitem) {

                    binding.progressbar2.visibility=View.VISIBLE
                    viewmodel.getDhaba(this@MainActivity,"27.2046","77.4977","50000","10",pageno.toString())
                    pageno++

                    Log.d("TAG", "onScrolled: "+pageno.toString())
                    Log.d("TAG", "onScrolled: ")
                    iscrolled=false
                }


            }
        })

    }
}