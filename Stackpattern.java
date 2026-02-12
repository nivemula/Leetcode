class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        
        String[] parts = path.split("/");
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue; // ignore
            } 
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // go up one directory
                }
            } 
            else {
                stack.push(part); // valid directory name
            }
        }
        
        // Build the result
        StringBuilder result = new StringBuilder();
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        
        return result.toString();
    }
}