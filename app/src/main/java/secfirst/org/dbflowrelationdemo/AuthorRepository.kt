package secfirst.org.dbflowrelationdemo

import com.raizlabs.android.dbflow.sql.language.Select
import secfirst.org.dbflowrelationdemo.models.Author

object AuthorRepository {

    fun getAll(): MutableList<Author> {
        return Select()
                .from(Author::class.java)
                .queryList()
    }

}