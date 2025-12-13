class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        
        // Valid business lines in required order
        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        // List of valid coupons with category index + code
        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String c = code[i];
            String bl = businessLine[i];

            // Condition 1: code must be non-empty & alphanumeric or underscore
            if (c.length() == 0 || !c.matches("[a-zA-Z0-9_]+")) {
                continue;
            }

            // Condition 2: business line must be valid
            if (!order.containsKey(bl)) continue;

            // Condition 3: coupon must be active
            if (!isActive[i]) continue;

            // Store category order + code
            valid.add(new String[]{bl, c});
        }

        // Sort by businessLine order, then lexicographically by code
        valid.sort((a, b) -> {
            int catA = order.get(a[0]);
            int catB = order.get(b[0]);
            if (catA != catB) return catA - catB;       // sort by category
            return a[1].compareTo(b[1]);                // then sort by code
        });

        // Extract only codes into final list
        List<String> result = new ArrayList<>();
        for (String[] item : valid) {
            result.add(item[1]);
        }

        return result;
    }
}
