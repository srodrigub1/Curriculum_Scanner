package com.example.curriculumscanner

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.curriculumscanner.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val cvList = mutableListOf<String>() // Simulando datos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del RecyclerView
        val adapter = CVAdapter(cvList)
        binding.recyclerViewCVs.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCVs.adapter = adapter

        toggleEmptyText()

        binding.buttonAdd.setOnClickListener {
            Toast.makeText(this, "Simulando agregar hoja (futura cámara)", Toast.LENGTH_SHORT).show()
            // Simulación:
            cvList.add("CV #${cvList.size + 1}")
            adapter.notifyItemInserted(cvList.size - 1)
            toggleEmptyText()
        }

        binding.buttonDelete.setOnClickListener {
            if (cvList.isNotEmpty()) {
                showConfirmationDialog {
                    cvList.clear()
                    adapter.notifyDataSetChanged()
                    toggleEmptyText()
                    Toast.makeText(this, "Se eliminaron todas las hojas de vida", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "No hay hojas de vida para eliminar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun toggleEmptyText() {
        if (cvList.isEmpty()) {
            binding.textViewEmpty.visibility = View.VISIBLE
        } else {
            binding.textViewEmpty.visibility = View.GONE
        }
    }

    private fun showConfirmationDialog(onConfirm: () -> Unit) {
        AlertDialog.Builder(this)
            .setTitle("¿Eliminar todo?")
            .setMessage("¿Estás seguro de que deseas eliminar todas las hojas de vida?")
            .setPositiveButton("Sí") { _, _ -> onConfirm() }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}
