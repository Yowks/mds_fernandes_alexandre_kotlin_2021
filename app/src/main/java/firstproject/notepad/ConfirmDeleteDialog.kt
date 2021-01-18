package firstproject.notepad

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDeleteDialog(val noteTitle : String ="") : DialogFragment() {

    interface ConfirmDeleteDialogListener{
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }
    var listener : ConfirmDeleteDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Delete the note \"$noteTitle\"?")
            .setPositiveButton("Delete",DialogInterface.OnClickListener{dialog , id -> listener?.onDialogPositiveClick()})
            .setNegativeButton("Cancel",DialogInterface.OnClickListener{ dialog, id -> listener?.onDialogNegativeClick()})
        return builder.create()
    }
}