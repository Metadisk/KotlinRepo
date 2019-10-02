package firatveral.com.kotlinrepo.commit;

import android.os.Parcel;

import org.junit.Test;

import firatveral.com.kotlinrepo.model.Author;
import firatveral.com.kotlinrepo.model.AuthorizedAuthor;
import firatveral.com.kotlinrepo.model.Commit;

import static org.junit.Assert.assertEquals;

public class CommitMapperUnitTest {

    private static final String AUTHORNAME = "Ilya Goncharov";
    private static final String AUTHORDATE = "1970-01-01";

    @Test
    public void testFromCommitDetail() {


        Author author = new Author();
        author.setName(AUTHORNAME);
        author.setDate(AUTHORDATE);

        AuthorizedAuthor authorizedAuthor = AuthorizedCommitMapper.fromAuthorDetail(new AuthorizedAuthor(), author);
        assertEquals(AUTHORNAME, authorizedAuthor.getName());
        assertEquals(AUTHORDATE, authorizedAuthor.getDate());


    }



}
