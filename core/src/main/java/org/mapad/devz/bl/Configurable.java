package org.mapad.devz.bl;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public abstract class Configurable {
	private static Config _conf;
	
	protected static Config getConf() {
		if (_conf == null) {
			_conf = ConfigFactory.load();
		}
		
		return _conf;
	}
}
