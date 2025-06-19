package com.mobile.bce1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.util.Locale
import android.content.Context
import android.content.Intent
import android.widget.Toast

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)



    }
    private fun startBackgroundTask(){
        val thread = Thread {
            Thread.sleep(7000)

            requireActivity().runOnUiThread {

                Toast.makeText(requireContext(), "Background Task Completed", Toast.LENGTH_SHORT).show()
            }
        }
        thread.start()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEnglish = view.findViewById<Button>(R.id.btnEnglish)

        val btnNepali = view.findViewById<Button>(R.id.btnNepali)

//        val btnDialoge = view.findViewById<Button>(R.id.btnDialoge)
        val btnPost = view.findViewById<Button>(R.id.btnPost)


        val intent = Intent(requireContext(), MainActivity::class.java)
        requireActivity().startService(intent)

        btnPost.setOnClickListener {
            val intent = Intent(requireContext(), MyService::class.java)
            requireContext().stopService(intent)
        }


        btnEnglish.setOnClickListener {
            setLocale("en")
        }

        btnNepali.setOnClickListener {
            setLocale("ne")
        }

    }

        private fun setLocale(languageCode: String) {
            val context = requireContext()
            val locale = Locale(languageCode)
            Locale.setDefault(locale)

            val config = context.resources.configuration
            config.setLocale(locale)
            context.resources.updateConfiguration(config, context.resources.displayMetrics)

            //save language
            val editor = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
            editor.putString("My_Lang", languageCode)
            editor.apply()

            //Recreate the Activity to apply the changes
            requireActivity().recreate()




        }


    }
