class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
         List<String> result = new ArrayList<>();
         Set<String> seen = new HashSet<>();
         Set<String> duplicates = new HashSet<>();

         for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (seen.contains(substring)) {
                duplicates.add(substring); 
            } else {
                seen.add(substring); 
            }
        }
        result.addAll(duplicates);
        return result;
    }
}