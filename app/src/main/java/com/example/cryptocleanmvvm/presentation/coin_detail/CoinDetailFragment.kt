package com.example.cryptocleanmvvm.presentation.coin_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.cryptocleanmvvm.domain.model.Coin
import com.example.cryptocleanmvvm.presentation.coin_list.CoinListViewModel

class CoinDetailFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val navController = findNavController()


        return ComposeView(requireContext()).apply { 
            setContent {

                Column() {
                    Text(text = "asada")
                }
            }
        }
    }
    
}