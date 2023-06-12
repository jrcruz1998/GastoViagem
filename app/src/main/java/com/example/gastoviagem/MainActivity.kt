package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
        binding.buttonClear.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        } else if (view.id == R.id.button_clear) {
            clear()
        }

    }

    // validar os dados informados
    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {

        if (isValid()) {

            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}" // vai formatar o "totalValue"
        } else {
            Toast.makeText(this, R.string.validation_fill_all_filds ,Toast.LENGTH_SHORT).show()
        }
    }

    private fun clear() {

        binding.editDistance.text.clear()
        binding.editPrice.text.clear()
        binding.editAutonomy.text.clear()

        binding.textTotalValue.text = "R$ 0"

        Toast.makeText(this, R.string.validation_clan_filds ,Toast.LENGTH_SHORT).show()
    }

}