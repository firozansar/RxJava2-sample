package info.firozansari.rxandroid_sample

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.subjects.PublishSubject

class MainActivity : AppCompatActivity() {
    private var mCounterDisplay: TextView? = null
    private var mIncrementButton: Button? = null
    private var mCounterEmitter: PublishSubject<Int>? = null
    private var mCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupExampleList()
    }

    private fun setupExampleList() {
        val exampleList = findViewById<View>(R.id.example_list) as RecyclerView
        exampleList.setHasFixedSize(true)
        exampleList.layoutManager = LinearLayoutManager(this)
        exampleList.setAdapter(ExampleAdapter(this, getExamples()))
    }

    private fun getExamples(): MutableList<ExampleActivityAndName>? {
        val exampleActivityAndNames: MutableList<ExampleActivityAndName> = ArrayList()
        exampleActivityAndNames.add(
            ExampleActivityAndName(
                Example1Activity::class.java,
                "Example 1: Simple Color List"
            )
        )
        exampleActivityAndNames.add(
            ExampleActivityAndName(
                Example2Activity::class.java,
                "Example 2: Favorite Tv Shows"
            )
        )
        exampleActivityAndNames.add(
            ExampleActivityAndName(
                Example3Activity::class.java,
                "Example 3: Improved Favorite Tv Shows"
            )
        )
        exampleActivityAndNames.add(
            ExampleActivityAndName(
                Example4Activity::class.java,
                "Example 4: Button Counter"
            )
        )
        exampleActivityAndNames.add(
            ExampleActivityAndName(
                Example5Activity::class.java,
                "Example 5: Value Display"
            )
        )
        exampleActivityAndNames.add(
            ExampleActivityAndName(
                Example6Activity::class.java,
                "Example 6: City Search"
            )
        )
        return exampleActivityAndNames
    }
}