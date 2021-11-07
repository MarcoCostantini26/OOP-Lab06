package it.unibo.oop.lab06.generics1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphImpl<N> implements Graph<N>{
	
	Map<N, Set<N>> edges = new HashMap<>();

	@Override
	public void addNode(N node) {
		if(!nodeExist(node)) {
			edges.put(node, new HashSet<>());
		}else {
			return;
		}
	}

	@Override
	public void addEdge(N source, N target) {
		if(nodeExist(source) && nodeExist(target)){
			edges.get(source).add(target);
		}
	}

	@Override
	public Set<N> nodeSet() {
		Set<N> allNodes = new HashSet<>(edges.keySet());
		return allNodes;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		Set<N> nodesTargetToNode = edges.get(node);
		return nodesTargetToNode;
	}

	@Override
	/*
	 * Using BFS to get path
	 * */
	public List<N> getPath(N source, N target) {
		List<N> pathList = new ArrayList<>();
		
		if(nodeExist(source) && nodeExist(target)) {
			Queue<N> q = new ArrayDeque<>();
			List<N> discovered = new ArrayList<>(numberOfNodes());
			discovered.add(source);
			q.add(source);
			while(!q.isEmpty()) {
				N v = q.poll();
				pathList.add(v);
				if (v == target) {
					return pathList;
				}
				for(N u : edges.get(v)) {
					if(!discovered.contains(u)) {
						discovered.add(u);
						q.add(u);
					}
				}
			}
		}
		return Collections.emptyList();
	}
	
	private int numberOfNodes() {
		return edges.keySet().size();
	}
	
	private boolean nodeExist(N node) {
		return edges.containsKey(node);
	}

}
