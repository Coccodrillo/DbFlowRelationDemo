package secfirst.org.dbflowrelationdemo.models

import com.raizlabs.android.dbflow.annotation.*
import com.raizlabs.android.dbflow.structure.BaseModel
import secfirst.org.dbflowrelationdemo.MyDatabase



@Table(name = "books", database = MyDatabase::class)
class Book() : BaseModel() {

    @PrimaryKey(autoincrement = true)
    @Column(name = "id")
    var id: Long = 0

    @Column()
    @ForeignKey(tableClass = Author::class, references = arrayOf(ForeignKeyReference(columnName = "parentId", foreignKeyColumnName = "id")), saveForeignKeyModel = true)
    var parentId: Long? = null

    @Column(name = "title")
    var title: String = ""

    @ForeignKey(stubbedRelationship = true)
    var author: Author? = null

    @Column(name = "releaseYear")
    var releaseYear: Int = 0

    override fun toString(): String {
        return String.format("Book: %s from %d", this.title, this.releaseYear)
    }
}