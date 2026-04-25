package com.example.mitravani.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Navigator(
    private val backStack: NavBackStack<NavKey>
) {
    fun navigate(screen: Screen) {
        backStack.add(screen)
    }

    fun clearAndNavigate(screen: Screen) {
        backStack.clear()
        backStack.add(screen)
    }

    fun pop() {
        if (backStack.size > 1) backStack.removeLastOrNull()
    }
}