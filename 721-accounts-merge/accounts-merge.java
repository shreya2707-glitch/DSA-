import java.util.*;

class Solution {
    class UnionFind {
        Map<String, String> parent = new HashMap<>();

        public String find(String s) {
            if (!parent.containsKey(s)) {
                parent.put(s, s);
            }
            if (!s.equals(parent.get(s))) {
                parent.put(s, find(parent.get(s))); // Path compression
            }
            return parent.get(s);
        }

        public void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (!rootA.equals(rootB)) {
                parent.put(rootA, rootB);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();

        // 1. Union emails belonging to the same account
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                uf.union(firstEmail, email);
                emailToName.put(email, name);
            }
        }

        // 2. Group emails by their root representative
        Map<String, List<String>> groups = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // 3. Sort emails and assemble final result
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(emailToName.get(entry.getKey())); // Add name
            account.addAll(emails);

            mergedAccounts.add(account);
        }

        return mergedAccounts;
    }
}