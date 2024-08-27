class Solution(object):
    def maxProbability(self, n, edges, succProb, start, end):
        """
        :type n: int
        :type edges: List[List[int]]
        :type succProb: List[float]
        :type start_node: int
        :type end_node: int
        :rtype: float
        """
        adj = defaultdict(list)
        sz = len(edges)
        for i in range(sz):
            u, v, cost = edges[i][0], edges[i][1], succProb[i]
            adj[u].append((cost, v))
            adj[v].append((cost, u))

        maxHeap = [(-1.0, start)]
        Prob = [0.0] * n
        Prob[start] = 1.0
        while maxHeap:
            cost, node = heapq.heappop(maxHeap)
            cost = -cost
            if node  == end: return cost
            for ccost, cnode in adj[node]:
                newcost = ccost * cost
                if newcost > Prob[cnode]:
                    Prob[cnode] = newcost
                    heapq.heappush(maxHeap, (-newcost, cnode))
        return 0.0
        