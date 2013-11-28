/*
 Copyright (C) 2011 Tim Blackler

 This source code is release under the BSD License.

 This file is part of JQuantLib, a free-software/open-source library
 for financial quantitative analysts and developers - http://jquantlib.org/

 JQuantLib is free software: you can redistribute it and/or modify it
 under the terms of the JQuantLib license.  You should have received a
 copy of the license along with this program; if not, please email
 <jquant-devel@lists.sourceforge.net>. The license is also available online at
 <http://www.jquantlib.org/index.php/LICENSE.TXT>.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the license for more details.

 JQuantLib is based on QuantLib. http://quantlib.org/
 When applicable, the original copyright notice follows this notice.
 */
package org.jquantlib.indexes;

import org.jquantlib.currencies.Europe.GBPCurrency;
import org.jquantlib.daycounters.Actual365Fixed;
import org.jquantlib.indexes.ibor.GBPLibor;

import org.jquantlib.termstructures.YieldTermStructure;
import org.jquantlib.time.BusinessDayConvention;
import org.jquantlib.time.Period;
import org.jquantlib.time.TimeUnit;
import org.jquantlib.time.calendars.Target;

/**
 * 
 * GbpLiborSwapIsdaFix index base class
 * GBP Libor Swap indexes fixed by ISDA in cooperation with
 * Reuters and Intercapital Brokers at 11am London.
 * Semiannual Actual/365F vs 6M Libor, 1Y Annual vs 3M Libor.
 * Reuters page ISDAFIX4 or GBPSFIX=.
 * Further info can be found at <http://www.isda.org/fix/isdafix.html> or
 * Reuters page ISDAFIX.
 * 
 * @author Tim Blackler
 */
public class GbpLiborSwapIsdaFix extends SwapIndex {

    public GbpLiborSwapIsdaFix(final Period tenor) {
    	this(tenor, null);
    }
	
    public GbpLiborSwapIsdaFix(final Period tenor, YieldTermStructure h) {
        super( "GbpLiborSwapIsdaFix",
                tenor,
                2, // settlement days
                new GBPCurrency(),
                new Target(),
                tenor.gt(new Period(1,TimeUnit.Years)) ? new Period(6,TimeUnit.Months):
                										 new Period(1,TimeUnit.Years),
                BusinessDayConvention.ModifiedFollowing,
                new Actual365Fixed(),
                tenor.gt(new Period(1,TimeUnit.Years)) ? new GBPLibor(new Period(6,TimeUnit.Months), h):
                	 									 new GBPLibor(new Period(3,TimeUnit.Months), h)
                		
                );
        }
}
