private long powerSum(long a, long b, int mod) {
		Map<Long, Long> map = new HashMap<>();
		
		long current = 1;
		long val = a;
		long result = 1;
		
		while (current <= b) {
			map.put(current, val);
			
			val = val * val;
			val %= mod;
			
			current *= 2;
		}
		
		while (current > 1) {
			current /= 2;
			
			if (b >= current) {
				b -= current;
				result *= map.get(current);
				result %= mod;
		}
	return result;
}