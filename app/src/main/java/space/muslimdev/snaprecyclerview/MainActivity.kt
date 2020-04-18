package space.muslimdev.snaprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapterRecycler by lazy { SnapAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        initLinearSnap()
        initPagerSnap()
    }

    private fun setupScrollListener(helper: SnapHelper, recyclerView: RecyclerView) {
        val snapOnScrollListener = SnapOnScrollListener(
            helper,
            onSnapPositionChangeListener = object : OnSnapPositionChangeListener {
                override fun onSnapPositionChange(position: Int) {
                    Log.i("ScrollPosition", "$position")
                }
            })
        recyclerView.addOnScrollListener(snapOnScrollListener)
    }

    private fun initAdapter() {
        rv_snap_linear.adapter = adapterRecycler
        rv_snap_pager.adapter = adapterRecycler
    }

    private fun initLinearSnap() {
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(rv_snap_linear)
        setupScrollListener(helper, rv_snap_linear)
    }

    private fun initPagerSnap() {
        val helper: SnapHelper = PagerSnapHelper()
        helper.attachToRecyclerView(rv_snap_pager)
        setupScrollListener(helper, rv_snap_pager)
    }
}
