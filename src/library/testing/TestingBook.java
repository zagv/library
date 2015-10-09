/**
 * 
 */
package library.testing;

import library.assignment3.Book;
import library.interfaces.entities.EBookState;

/**
 * Test Testcases using JUnit Framework
 * @author vuq
 *
 */
public class TestingBook {
	
	private int id = 001;
	private String author = "M.Baums";
	private String title = "JavaForDummies";
	private String callNumber = "123456";
	private Book book;
	TestingBook testingBook;
	private EBookState state;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		book = new Book("M.Baums", "JavaForDummies", "123456", 001);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	/***
	 * This is just a test sample
	 * @author vuq
	 * **/
	@Test
	public void addNewBook() {
		assertEquals(book.getID(),this.id);
		assertEquals(book.getTitle(), this.title);
		assertEquals(book.getAuthor(), this.author);
		assertEquals(book.getCallNumber(), this.callNumber);
	}
	@Test
	public void dispose()
	{
		
	}
}
