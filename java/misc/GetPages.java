/**
* Returns a list of lists making pagination possible
* @param c The list to turn into pages
* @param pageSize The page size to limit the list to
* @param <T> The list type                 
* @return A list of lists of pages
*/
public static <T> List<List<T>> getPages(Collection<T> c, Integer pageSize) {
    if (c == null)
        return Collections.emptyList();
    List<T> list = new ArrayList<>(c);
    if (pageSize == null || pageSize <= 0 || pageSize > list.size())
        pageSize = list.size();
    int numPages = (int) Math.ceil((double)list.size() / (double)pageSize);
    List<List<T>> pages = new ArrayList<>(numPages);
    for (int pageNum = 0; pageNum < numPages;)
        pages.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));
    return pages;
}
