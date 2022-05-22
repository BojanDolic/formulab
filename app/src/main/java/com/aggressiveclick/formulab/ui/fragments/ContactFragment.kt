package com.aggressiveclick.formulab.ui.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aggressiveclick.formulab.R
import com.aggressiveclick.formulab.databinding.FragmentContactBinding
import com.aggressiveclick.formulab.databinding.MainFragmentBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class ContactFragment : Fragment() {

    private val facebook_url = "https://www.facebook.com/autoskolaformulabdrive"
    private val instaUrl = "https://www.instagram.com/autoskolaformulab/"
    private val websiteUrl = "https://www.autoskolaformulab.com/"

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.facebookBtn.setOnClickListener {
            var uri = Uri.parse(facebook_url);

            try {
                val appInfo =
                    requireContext().packageManager.getApplicationInfo("com.facebook.katana", 0)

                if (appInfo.enabled) {
                    uri = Uri.parse("fb://facewebmodal/f?href=" + facebook_url)
                }

            } catch (ignored: PackageManager.NameNotFoundException) {
                Log.e("TAG", "onViewCreated: ", ignored)
            }
            val intent = Intent(Intent.ACTION_VIEW, uri)

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Unable to launch activity", Snackbar.LENGTH_SHORT)
                    .show()
            }

        }

        binding.instagramBtn.setOnClickListener {
            val uri = Uri.parse(instaUrl);
            val intent = Intent(Intent.ACTION_VIEW, uri)

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Unable to launch activity", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        binding.websiteBtn.setOnClickListener {
            val uri = Uri.parse(websiteUrl);
            val intent = Intent(Intent.ACTION_VIEW, uri)

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Unable to launch activity", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }


    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}