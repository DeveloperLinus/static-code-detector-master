package com.lovejjfg.detekttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        foo("xxx")
        return inflater?.inflate(R.layout.fragment_first, container, false)
    }

    fun foo(s: String) {
        val a = 1
        // UnnecessaryNotNullOperator
        val b = a
        // UnsafeCallOnNullableType
        val and = b.and(2!!)
        if (and > 0) {
            println("jahahaa")
        }
        val a1: String = ""
        // UnnecessarySafeCall
        val b1 = a1?.length
        println(b1)
        // UnnecessarySafeCall
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view!!.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}
