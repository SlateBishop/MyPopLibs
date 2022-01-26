package ru.gb.makulin.mypoplibs

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import ru.gb.makulin.mypoplibs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val presenter = MainPresenter(this)
    private val listener = View.OnClickListener {
        presenter.counterClick(converButtonIdtoButtonEnum(it.id))
    }

    private fun converButtonIdtoButtonEnum(@IdRes id: Int): Int {
        return when (id) {
            binding.btnCounterFirst.id -> Button.FIRST.id
            binding.btnCounterSecond.id -> Button.SECOND.id
            binding.btnCounterThird.id -> Button.THIRD.id
            else -> Button.ERR.id
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initButtons()

    }

    private fun initButtons() {
        with(binding) {
            btnCounterFirst.setOnClickListener(listener)
            btnCounterSecond.setOnClickListener(listener)
            btnCounterThird.setOnClickListener(listener)
        }
    }

    override fun setFirstButtonText(text: String) {
        binding.btnCounterFirst.text = text
    }

    override fun setSecondButtonText(text: String) {
        binding.btnCounterSecond.text = text
    }

    override fun setThirdButtonText(text: String) {
        binding.btnCounterThird.text = text
    }
}