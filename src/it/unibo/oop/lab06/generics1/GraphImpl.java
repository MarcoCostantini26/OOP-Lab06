package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N>{
	
	Set<N> nodes = new HashSet<>();
	//la chiave rappresenta la src il valore rappresenta tutti i target del src
	Map<N, Set<N>> edges = new HashMap<>();

	@Override
	public void addNode(N node) {
		nodes.add(node);
	}

	@Override
	public void addEdge(N source, N target) {
		Set<N> nodesFromSource = edges.get(source);
		nodesFromSource.add(target);
		edges.put(source, nodesFromSource);
		
	}

	@Override
	public Set<N> nodeSet() {
		return this.nodes;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		Set<N> nodesTargetToNode = edges.get(node);
		return nodesTargetToNode;
	}

	@Override
	public List<N> getPath(N source, N target) {
		// TODO Auto-generated method stub
		return null;
	}

}
