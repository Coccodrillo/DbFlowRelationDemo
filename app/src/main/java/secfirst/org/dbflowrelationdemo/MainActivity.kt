package secfirst.org.dbflowrelationdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import secfirst.org.dbflowrelationdemo.models.Author
import secfirst.org.dbflowrelationdemo.models.Book

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val authorList = AuthorRepository.getAll();
            if (authorList.size > 0) {
                text_view.text = authorList.joinToString()
            } else {
                val author = createAuthorAndBooks()
                author.save()
            }
        }
    }

    fun createAuthorAndBooks(): Author {
        val books = ArrayList<Book>()
        val b1 = Book()
        b1.title = "First"
        b1.releaseYear = 2011
        val b2 = Book()
        b2.title = "Second"
        b2.releaseYear = 2013
        books.add(b1)
        books.add(b2)
        val author = Author()
        author.name = "Author Name"
        author.books = books
        return author
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
