package firatveral.com.kotlinrepo.commit;

import firatveral.com.kotlinrepo.model.Author;
import firatveral.com.kotlinrepo.model.AuthorizedAuthor;

public class AuthorizedCommitMapper {

    private AuthorizedCommitMapper() {
    }

    public static AuthorizedAuthor fromAuthorDetail(AuthorizedAuthor currentAuthorizedAuthor, Author author) {

        currentAuthorizedAuthor.setName(author.getName());
        currentAuthorizedAuthor.setDate(author.getDate());


        return currentAuthorizedAuthor;
    }
}
