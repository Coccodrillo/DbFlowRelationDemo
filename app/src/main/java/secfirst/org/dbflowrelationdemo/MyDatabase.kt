package secfirst.org.dbflowrelationdemo

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION, generatedClassSeparator = "_")
object MyDatabase {
    const val NAME = "DataBase"
    const val VERSION = 2
}