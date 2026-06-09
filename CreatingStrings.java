import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CreatingStrings {
    static List<String> ans = new ArrayList<>();

    private static void createString(char[] arr, StringBuilder sb, boolean[] visited) {

        if (sb.length() == arr.length) {
            ans.add(sb.toString());
            return;
        }

        boolean[] vis = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;
            vis[i] = true;
            if (i > 0 && arr[i] == arr[i - 1] && vis[i - 1])
                continue;

            sb.append(arr[i]);
            visited[i] = true;
            createString(arr, sb, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        createString(arr, new StringBuilder(), new boolean[arr.length]);

        System.out.println(ans.size());
        for (String str : ans)
            System.out.println(str);
    }
}
