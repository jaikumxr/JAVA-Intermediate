public class NearestMeetingCell {

    public static void bfs(int[] arr, int idx, int lvl, int[] visited) {
        visited[idx] = lvl;
        if (arr[idx] != -1 && visited[arr[idx]] == -1) {
            bfs(arr, arr[idx], lvl + 1, visited);
        }
    }

    int solution(int[] arr, int src, int dest) {
        int n = arr.length;
        int[] visited1 = new int[n];
        int[] visited2 = new int[n];

        for (int i = 0; i < n; i++) {
            visited1[i] = visited2[i] = -1;
        }

        bfs(arr, src, 1, visited1);
        bfs(arr, dest, 1, visited2);

        int dist = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (visited2[i] != -1 && visited1[i] != -1) {
                if (visited1[i] + visited2[i] < dist) {
                    dist = visited2[i] + visited1[i];
                    node = i;
                }
            }
        }
        return node;

    }

    public static void main(String[] args) {

    }
}
