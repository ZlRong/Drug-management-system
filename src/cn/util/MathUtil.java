package cn.util;

import java.math.BigInteger;

public class MathUtil {

	public static Long valueToLong(Object value){
		BigInteger v = (BigInteger)value;
		return v.longValue();
	}
}
