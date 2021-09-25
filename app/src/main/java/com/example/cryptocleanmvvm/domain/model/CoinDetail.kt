package com.example.cryptocleanmvvm.domain.model

import com.example.cryptocleanmvvm.data.remote.dto.TeamMember
import java.lang.reflect.Member

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
