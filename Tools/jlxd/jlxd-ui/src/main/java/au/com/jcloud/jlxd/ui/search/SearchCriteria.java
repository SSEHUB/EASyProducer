package au.com.jcloud.jlxd.ui.search;

public class SearchCriteria {

	private String searchTerm;

	@Override
	public String toString() {
		return "SearchCriteria [searchTerm=" + searchTerm + "]";
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
