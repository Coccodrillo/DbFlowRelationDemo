package secfirst.org.dbflowrelationdemo.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.OneToMany
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.raizlabs.android.dbflow.structure.BaseModel
import secfirst.org.dbflowrelationdemo.MyDatabase


@Table(name = "authors", database = MyDatabase::class)
class Author() : BaseModel() {
    @PrimaryKey(autoincrement = true)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "name")
    var name: String = ""

    var books: List<Book> = ArrayList()
    @OneToMany(methods = arrayOf(OneToMany.Method.ALL), variableName = "books")
    fun getMyBooks(): List<Book>? {
        if (books.isEmpty()) {
            books = SQLite.select()
                    .from<Book>(Book::class.java)
                    .where(Book_Table.author_id.eq(id))
                    .queryList()
        }
        return books
    }

    override fun save(): Boolean {
        val res = super.save()
        for (b in books) {
            b.author = this
            b.save()
        }
        return res

    }

    override fun toString(): String {
        var s = String.format("Author: %s", this.name)
        for (item in this.books) {
            s += "\n" + item.toString()
        }
        return s
    }
}