class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int minCost = directPurchase(price, needs);

        for (List<Integer> offer : special) {
            List<Integer> remainingNeeds = new ArrayList<>(needs);
            boolean validOffer = true;

            for (int i = 0; i < needs.size(); i++) {
                if (offer.get(i) > needs.get(i)) {
                    validOffer = false; 
                    break;
                }
                remainingNeeds.set(i, needs.get(i) - offer.get(i));
            }

            
            if (validOffer) {
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, remainingNeeds, memo));
            }
        }

        
        memo.put(needs, minCost);
        return minCost;
    }

    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int totalCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            totalCost += price.get(i) * needs.get(i);
        }
        return totalCost;
    }

}
