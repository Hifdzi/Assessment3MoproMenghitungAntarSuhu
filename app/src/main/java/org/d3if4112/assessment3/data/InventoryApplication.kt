package org.d3if4112.assessment3.data

import android.app.Application
import org.d3if4112.assessment3.db.SuhuDb

class InventoryApplication : Application() {
    // Using by lazy so the database is only created when needed
    // rather than when the application starts
    val database: SuhuDb by lazy { SuhuDb.getInstance(this) }
}
