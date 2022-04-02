package com.mcdev.tweeze

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.mcdev.tweeze.databinding.TwitterUsernameViewBinding
import com.mcdev.tweeze.util.TWITTER_AT_SYMBOL

/** A convenient view sets the username of a twitter user.
 * This view prepends the at(@) symbol to the user's username. */
class TwitterUsernameView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defaultStyle: Int = 0
) : FrameLayout(context, attributeSet, defaultStyle) {

    private val binding = TwitterUsernameViewBinding.inflate(LayoutInflater.from(context), this, true)

    var username: String? = null /** Get user's username.*/
        get() = field.toString()
        set(value) {
            field = if (value!!.startsWith(TWITTER_AT_SYMBOL).not()) { //if does not start with the @ symbol, do not append another @ symbol
                TWITTER_AT_SYMBOL.plus(value)
            } else {
                value
            }
            binding.tweezeUsername.text = field

        }

    /**
     * Return the user's username without the @ symbol*/
    val usernameWithoutSymbol: String?
        get() {
            return if (this.username.isNullOrBlank()) {
                null //return null if the username is null or blank. This will prevent returning the @ symbol when it is null or blank
            } else {
                username.toString().removePrefix(TWITTER_AT_SYMBOL)
            }
        }

    /**
     * Get the textview object to customize it*/
    val textView: TextView
        get() = binding.tweezeUsername

    init {
        val a = context.obtainStyledAttributes(
            attributeSet, R.styleable.TwitterUsernameView, defaultStyle, 0
        )


        /*TypedArrays are heavyweight objects that should be recycled immediately
        after all the attributes you need have been extracted.*/
        a.recycle()
    }
}